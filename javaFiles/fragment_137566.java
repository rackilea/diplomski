public class Grid {
        private int m_depth;
        private Object m_root;
        ...
        public int get( int ... indices ) {
            assert( indices.length == m_depth );
            Object level = m_root;
            for ( int i = 0; i + 1 < m_depth; ++i ) {
                level = ((Object[]) level)[ indices[i] ];
            }
            int[] row = (int[]) level;
            return row[ indices[m_depth - 1] ];
        }
   }