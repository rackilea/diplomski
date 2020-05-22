private int getDraw(int reassembled_chunks_image_data, int rescaled_chunk_data, int index) {
    int result = index;
    int delta = reassembled_chunks_image_data - (index + rescaled_chunk_data);
    if (delta < 0) {
        result -= Math.abs(delta);
    }
    return result;
}