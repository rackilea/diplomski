double rX = rayBX - rayAX;                                                                                                                                           
double rY = rayBY - rayAY;                                                                                                                                           

double sAX = segAX - rayAX;                                                                                                                                          
double sAY = segAY - rayAY;                                                                                                                                          
double areaA = sAX * rY - sAY * rX;                                                                                                                                  

double sBX = segBX - rayAX;                                                                                                                                          
double sBY = segBY - rayAY;                                                                                                                                          
double areaB = sBX * rY - sBY * rX;                                                                                                                                  

double t = areaA / (areaA - areaB);
// if t is not between 0 and 1, intersection is not in segment                                                                                                 
double x = (1 - t) * segAX + t * segBX;                                                                                                                              
double y = (1 - t) * segAY + t * segBY;