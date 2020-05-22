Random rnd = new Random();
        ArrayList<Integer> randomNumbers = new ArrayList<Integer>();
        while (randomNumbers.size() < 4)
        {
            int num = rnd.nextInt(9);
            if (!randomNumbers.contains(num))
                randomNumbers.add(num);
        }

        for (int i=0;i<allImageButtons.size();i++)
        {
            if (randomNumbers.contains(i))
                allImageButtons.get(i).setVisibility(View.VISIBLE);
            else
                allImageButtons.get(i).setVisibility(View.GONE);
        }