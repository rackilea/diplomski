Map<String, String> fileMap = new HashMap<>();
fileMap.put("Age", "Age is not remotely associated with it.");
fileMap.put("Gender", "Gender plays a role but not that important.");
fileMap.put("Money", "People do not believe but this is the only factor that matters.");


final int[] tgSize = new int[]{0};
final Map.Entry[][] entryArr = new Map.Entry[1][];

Runnable myRunnable = new Runnable(){
    public void run(){
        Integer index = Integer.valueOf(Thread.currentThread().getName().substring(8));

        for(int i = index; i < fileMap.size(); i += tgSize[0]) {
            int counter = 0;
            @SuppressWarnings("unchecked")
            Map.Entry<String, String> entry = entryArr[0][i];
            Pattern p = Pattern.compile("not");
            Matcher m = p.matcher(entry.getValue());
            while (m.find()) {
                counter++;
            }
            synchronized(this) {
                System.out.println("File Name: " + entry.getKey());
                System.out.println("Count: " + counter);
                System.out.println(Thread.currentThread().getName());            
            }
        }
    }    
};

int n = Integer.parseInt(args[0]);

tgSize[0] = n < fileMap.size() ? n : fileMap.size();
entryArr[0] = fileMap.entrySet().toArray(new Map.Entry[fileMap.size()]);


for (int x=0; x<n && x < fileMap.size(); x++)
{
    Thread temp= new Thread(myRunnable, "Thread #" + x);
    temp.start();
    System.out.println("Started Thread:" + x);
}