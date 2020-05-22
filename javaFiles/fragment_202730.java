// Back to the basics of decoding an object :)
             if (m.getClass().isArray()) {
                 if (m instanceof double[]) {
                     value = Arrays.toString((double[])m);
                 } else if (m instanceof int[]) {
                     value = Arrays.toString((int[])m);
                 }
             }