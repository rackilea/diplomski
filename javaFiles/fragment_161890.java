char[] alphabet= {'a','á','b','c','č','d','ď','e','é','ě','f','g','h',
            'i','í','j','k','l','m','n','ň','o','ó','p','q','r','ř','s','š','t','ť',
            'u','ú','ů','v','w','x','y','ý','z','ž','A','Á','B','C','Č','D','Ď','E','É',
            'Ě','F','G','H','I','Í','J','K','L','M','N','Ň','O','Ó','P','Q','R','Ř','S','Š','T',
            'Ť','U','Ú','Ů','V','W','X','Y','Ý','Z','Ž',' '};



                String vlozena = userInputScanner.nextLine();
                String fileContentsSingle = "";
                Integer lenght = vlozena.length();
                int j ;
                char cha;

                        /*
                         * kontroluje, zda se jedná o mezeru či písmeno české abecedy
                         * a poté jej přidá, pokud vyhovuje, do věty
                         */
                for (j = 0; j<lenght;j++) {
                    cha = vlozena.charAt(j);
                    for (char z : abeceda) {
                        if (cha == z) {
                            fileContentsSingle = fileContentsSingle + cha;
                        }
                    }
                }

                fileContentsSingle = fileContentsSingle.replaceAll("\\s+", " ");
                fileContentsSingle = fileContentsSingle.toLowerCase();
                String[] vetaNaArraySingle = fileContentsSingle.split("\\s+",-1);