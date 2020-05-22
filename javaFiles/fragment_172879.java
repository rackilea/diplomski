// assuming Mat it's of CV_32S type
int buff[] = new int[your_mat.total() * your_mat.channels()];

your_mat.get(0, 0, buff);

// buff is now Mat converted to int[]

your_mat.put(0, 0, buff); // after processing buff, convert it back to Mat type