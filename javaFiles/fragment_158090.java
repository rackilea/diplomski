curvePoints[j].x = (int) Math.round(controlPoints[i - 4].x * (1.0 - t) * (1.0 - t) * (1.0 - t)
                                  + controlPoints[i - 3].x * 3.0 * t * (1.0 - t) * (1.0 - t)
                                  + controlPoints[i - 2].x * 3.0 * t * t * (1.0 - t) 
                                  + controlPoints[i - 1].x * t * t * t);

curvePoints[j].y = (int) Math.round(controlPoints[i - 4].y * (1.0 - t) * (1.0 - t) * (1.0 - t)
                                  + controlPoints[i - 3].y * 3.0 * t * (1.0 - t) * (1.0 - t)
                                  + controlPoints[i - 2].y * 3.0 * t * t * (1.0 - t) 
                                  + controlPoints[i - 1].y * t * t * t);