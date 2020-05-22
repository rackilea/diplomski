@Override
public void run() {
    for(int i = 0; i < 100; i++) {
        String s = null;
        synchronized (infiList) {
            if(infiList.isEmpty())
                infiList.add("This");
            else
            {
                s = infiList.get(infiList.size()-1);

            if(s.equals("This"))
                infiList.add("is");
            else if(s.equals("is"))
                infiList.add("infinite");
            else if(s.equals("infinite"))
                infiList.add("This");
            }
        }
    }
}