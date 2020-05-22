Iterator i = threads.listIterator();
                while (i.hasNext()) {
                    ClientThread c = (ClientThread) i.next();
                    if (c == this) {
                        c.interrupt();
                        i.remove();
                        frame.changeTitle();
                    }
                }