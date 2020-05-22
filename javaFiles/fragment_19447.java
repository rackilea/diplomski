while (itr.hasMoreTokens()) {
            String token = itr.nextToken();
            if(token.startsWith("c")){
                word.set("C_Count");
                output.collect(word, one);
            }

        }