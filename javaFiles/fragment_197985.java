// a field in your Matrix class
Object[] row_locks;

// initialized like this (probably in your constructor, or whenever the matrix is resized)
for(int row_index = 0; row_index < number_of_rows; row_index++)
    row_locks[row_index] = new Object();

// and used like this:
synchronized(row_locks[row_index]) {
    // do stuff with the row_index'th row here
}