class ChunkOctree
    {
    private:
        union Fork
        {
            ChunkOctree *branch;
            Chunk *leaf;
        };
        Fork forking[2][2][2];
    }