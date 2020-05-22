// code simplified for demonstration
            double angleBetweenVertices;
            double maxAngleBetweenVertices;
            vectorA.setStartingPoint(outerPoint);
            vectorA.setTerminationPoint(polygonCenter);
            vectorB.setStartingPoint(outerPount);

            // For each vertex, calculate the angle between the outer point, the polygon's center and the vertex
            for (Point2D.Double vertex : vertices) {    
                vectorB.setTerminationPoint(vertex);
                double angleBetweenVertices = 
                    Math.toDegrees(
                        Math.atan2(
                            (vectorA.perpDotProduct(vectorB)),
                            (vectorA.dotProduct(vectorB)) 
                        )
                    );

                // Update the min and Max
                if (angleBetweenVertices >= maxAngleBetweenVertices) {
                    maxVertex = vertex;
                    maxAngleBetweenVertices = angleBetweenVertices;
                } else if (angleBetweenVertices <= minAngleBetweenVertices) {
                    minVertex = vertex;
                    minAngleBetweenVertices = angleBetweenVertices;
                }
            }