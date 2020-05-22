if(openSet.contains(neighbor)) {
                if(tempG < neighbor.getG()) {
                    openset.remove(neighbor); // *3
                    neighbor.setG(tempG);
                }
            } else {
                neighbor.setG(tempG);
                // openSet.add(neighbor); // *4
            }

            neighbor.setH(heuristic(neighbor, end));
            neighbor.setF(neighbor.getG() + neighbor.getH());
            openSet.add(neighbor); // *5
            neighbor.setPrevious(current);