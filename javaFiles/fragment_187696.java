// You need fresh vars, don't accumulate the derivatives across gradient descent iterations

derivative0 = 0;                                                      
derivative1 = 0;

for (int i = 0; i < m; i++) {                       
    derivative0 += (1/m) * (theta0 + (theta1 * x1[i]) - y[i]);          
    derivative1 += (1/m) * (theta0 + (theta1 * x1[i]) - y[i])*x1[i];    
}