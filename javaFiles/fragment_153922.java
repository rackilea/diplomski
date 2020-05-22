System.out.println(firstNode);
            LinkedList<Board> queue = new LinkedList<Board>();
            queue.addFirst(firstNode);
            Board solved = null;
            while (queue.size() != 0) {
                    Board b = queue.get(0);

                    System.out.println("!===========\ns: " + queue.size() + "\n");
                    //for (int i = 0; i < queue.size(); i++){System.out.println(queue.get(i));}
                    queue.remove(0);