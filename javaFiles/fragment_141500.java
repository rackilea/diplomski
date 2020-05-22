Random random = new Random();
                            ArrayList<Challenges> temp = new ArrayList<Challenges>(listChallenges.size());
                            for (Challenges item : listChallenges) temp.add(item);
                            while (finalChallenges.size()<21 && temp.size()>0) {
                                   int index = random.nextInt(temp.size());
                                   finalChallenges.add(temp.get(index));
                                   temp.remove(index);
                            }