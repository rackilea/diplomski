...
            if (pZiegel.isEmpty()) { 
                ziegelHinzufügen = true;
                pZiegel = new List();  // <---- this line
                for (int i = 1; i <= n; i++) {
                    pZiegel.append(i);
                }
            }
...