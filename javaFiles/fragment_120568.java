ArrayList<Node> seriesNodes = new ArrayList<Node>();
Set<Node> nodes = scatterChart.lookupAll(.series0); 
                    int flag=0;
                    for (Node n : nodes) {
                        n.setStyle("-fx-blend-mode: multiply ;");
                         if(flag==0){
                             seriesNodes.add(n);
                         }
                         flag++;
                    }