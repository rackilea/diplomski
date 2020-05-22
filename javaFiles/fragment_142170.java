if(openSet.contains(neighbor)) {
                if(tempG < neighbor.getG()) {
                    neighbor.setG(tempG); // *1
                }
            } else {
                neighbor.setG(tempG);
                openSet.add(neighbor);
            }

            neighbor.setH(heuristic(neighbor, end));
            neighbor.setF(neighbor.getG() + neighbor.getH()); // *2
            neighbor.setPrevious(current);