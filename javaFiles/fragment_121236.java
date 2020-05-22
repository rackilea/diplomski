struct Cell {
  1: string did
  2: double l_x
  3: double l_y
  4: double l_z
  5: double m_x
  6: double m_y
  7: double m_z
  8: double a_x
  9: double a_y
  10: double a_z
  11: double g_x
  12: double g_y
  13: double g_z
  14: string d_t
  15: double tp
  16: double r_q
  17: string o_m
  18: double b_v
}

service test{
    list<Cell>  number( 1 : i16 req)
}