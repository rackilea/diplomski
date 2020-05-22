StringBuilder str = new StringBuilder();
str.append("[");
for(int i = front; i<= rear; i++){
    str.append(Q[i] + ",");  
}
str.append(Q[rear] + "]");