byte messageDigest[] = m.digest();

            hexString = new StringBuffer();
            for (int i=0;i<messageDigest.length;i++) {
                String hex=Integer.toHexString(0xFF & messageDigest[i]);
                if(hex.length()==1)
                    hexString.append('0');

                hexString.append(hex);
            }