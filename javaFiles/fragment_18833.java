import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ParallelizeListSearch {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        List<String> searchList = new ArrayList<String>(7);
        searchList.add("hello");
        searchList.add("world");
        searchList.add("java");
        searchList.add("debian");
        searchList.add("linux");
        searchList.add("jsr-166");
        searchList.add("stack");

        Set<String> targetSet = new HashSet<String>(searchList);

        Set<String> matchSet = findMatches(searchList, targetSet);
        System.out.println("Found " + matchSet.size() + " matches");
        for(String match : matchSet){
            System.out.println("match:  " + match);
        }
    }

    public static Set<String> findMatches(List<String> searchList, Set<String> targetSet) throws InterruptedException, ExecutionException {
        Set<String> locatedMatchSet = new HashSet<String>();

        int threadCount = Runtime.getRuntime().availableProcessors();   

        List<List<String>> partitionList = getChunkList(searchList, threadCount);

        if(partitionList.size() == 1){
            //if we only have one "chunk" then don't bother with a thread-pool
            locatedMatchSet = new ListSearcher(searchList, targetSet).call();
        }else{  
            ExecutorService executor = Executors.newFixedThreadPool(threadCount);
            CompletionService<Set<String>> completionService = new ExecutorCompletionService<Set<String>>(executor);

            for(List<String> chunkList : partitionList)
                completionService.submit(new ListSearcher(chunkList, targetSet));

            for(int x = 0; x < partitionList.size(); x++){
                Set<String> threadMatchSet = completionService.take().get();
                locatedMatchSet.addAll(threadMatchSet);
            }

            executor.shutdown();
        }


        return locatedMatchSet;
    }

    private static class ListSearcher implements Callable<Set<String>> {

        private final List<String> searchList;
        private final Set<String> targetSet;
        private final Set<String> matchSet = new HashSet<String>();

        public ListSearcher(List<String> searchList, Set<String> targetSet) {
            this.searchList = searchList;
            this.targetSet = targetSet;
        }

        @Override
        public Set<String> call() {
            for(String searchValue : searchList){
                if(targetSet.contains(searchValue))
                    matchSet.add(searchValue);
            }

            return matchSet;
        }

    }

    private static <T> List<List<T>> getChunkList(List<T> unpartitionedList, int splitCount) {
        int totalProblemSize = unpartitionedList.size();
        int chunkSize = (int) Math.ceil((double) totalProblemSize / splitCount);

        List<List<T>> chunkList = new ArrayList<List<T>>(splitCount);

        int offset = 0;
        int limit = 0;
        for(int x = 0; x < splitCount; x++){
            limit = offset + chunkSize;
            if(limit > totalProblemSize)
                limit = totalProblemSize;
            List<T> subList = unpartitionedList.subList(offset, limit);
            chunkList.add(subList);
            offset = limit;
        }

        return chunkList;
    }

}