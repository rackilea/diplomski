for(int i=0;i<n;i++){
            String word = sc.next();
            if(wordCount.containsKey(word)){
                wordCount.put(word,wordCount.get(word)+1));
            }
            else{
                 wordCount.put(word,1);
            }
        }