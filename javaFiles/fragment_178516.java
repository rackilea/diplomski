Pattern pattern = Pattern.compile("\\W+");
        HashMap<String, AtomicInteger> tableOfWords = new HashMap<String, AtomicInteger>();

        while (file.hasNextLine()){
            words = pattern.split(file.nextLine());
            for (String w : words){
                String tmp = w;
                if (!is_case_sensitive){
                    tmp = String.valueOf(w.toLowerCase());
                }

                AtomicInteger count = tableOfWords.get(tmp);
                if (count == null){
                    count = new AtomicInteger(0);
                }
                count.incrementAndGet();
                tableOfWords.put(tmp,count);
            }
        }