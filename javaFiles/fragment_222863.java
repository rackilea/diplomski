FileWriter fstream = new FileWriter(outputFileName, false); //false tells to not append data.
            BufferedWriter out = new BufferedWriter(fstream);
            for (int i=0; i<numBins; ++i){
                String str=Integer.toString(hist[i]);
                str.concat("\n");
                out.write(str);
            }
            out.close();