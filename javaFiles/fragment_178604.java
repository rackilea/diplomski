for (int i = 0; i < teacher; i++)    
    {
        a[i] = r.nextInt(total) + 1; 
        for (int j = 0; j < i; j++) 
        {
            if (a[i] == a[j]) {
                i--;
            }
        }

        if (playerArrayList.get(a[i] - 1).id == a[i]) { 
            playerArrayList.get(a[i] - 1).setTeacher();
        }

    }
}