import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PartitionArray {

    private static <T> Collection<List<T>> partitionBasedOnSize(List<T> inputList, int partitionSize) {
        Collection<List<T>> collection = new ArrayList<>();
        int remainingSize = inputList.size();
        int index = 0;
        while (remainingSize > partitionSize) {
            collection.add(inputList.subList(index, index + partitionSize));
            remainingSize -= partitionSize;
            index += partitionSize;
        }
        collection.add(inputList.subList(index, index + remainingSize));
        return collection;
    }

    public static <D, T> List<D> partitionAndDoBusinessFunction(List<T> ids, Function<List<T>, List<D>> businessFunction, int partitionSize) {
        List<D> dataList = new ArrayList<>();
        Collection<List<T>> idListCollection = partitionBasedOnSize(ids, partitionSize);
        for (List<T> idList : idListCollection) {
            dataList.addAll(businessFunction.apply(idList));
        }
        return dataList;
    }
}