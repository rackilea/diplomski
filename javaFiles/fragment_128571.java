double[] oldArr = gradeTable[index];
    double[] newArr = new double[oldArr.length - 1];
    int i = 0;
    for (double element : oldArr)
    {
        if (element != grade)
        {
            newArr[i++] = element;
        }
    }
    gradeTable[index] = newArr;