StringBuilder sb = new StringBuilder();
for( i = 0 ; i < len2 ; i++ ) {
    sb.append(accelX[i]).append(", ");
    sb.append(accelY[i]).append(", ");
    sb.append(accelZ[i]).append(", ");
    sb.append(accelT[i]).append(", ");
    sb.append(latitu[i]).append(", ");
    sb.append(longit[i]).append(", ");
    sb.append(orient[i]).append(", ");
    sb.append(magneX[i]).append(", ");
    sb.append(magneY[i]).append(", ");
    sb.append(magneZ[i]).append(", ");
    sb.append(millis[i]).append("\n");
}