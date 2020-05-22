package com.example.sampl;

    public class MainSampl {



        public static void main(String[] args) {
            Person p = new Person();
            boolean correct = isCorrect(p);
            System.out.println(correct);
        }

        private static boolean isCorrect(Person person){
            return  isNotNull(person) &&
                    isNotNull(person.getWallet()) &&
                    isNotNull(person.getWallet().getWalletItems()) &&
                        isNotNull(person.getWallet().getWalletItems().getItems().get(0));
//etc
        }

        private static boolean isNotNull(Object data) {
            return data != null;
        }

    }