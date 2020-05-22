int vertexDistance = vertexMinDistance.get(adjVertex);
                int newDistance = sourceDistance + edge.getDistance();
                if (vertexDistance > newDistance ) {
                    vertexMinDistance.put(adjVertex, newDistance );
                    queue.add(adjVertex);
                }