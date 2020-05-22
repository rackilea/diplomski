while ((line = br.readLine()) != null) {

                if(line.contains("$")){ 
                    sb.append(line.replaceAll("\\$\\{(.+)\\}", "\\${$1" +"_SUFFIX}") + "\n");
                }else{
                    sb.append(line + "\n");
                }

            }