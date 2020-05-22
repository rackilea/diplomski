0x00007f4a811848cf: movslq %ebp,%r10
0x00007f4a811848d2: mov    %ebp,%r9d
0x00007f4a811848d5: sar    $0x1f,%r9d
0x00007f4a811848d9: imul   $0x55555556,%r10,%r10
0x00007f4a811848e0: sar    $0x20,%r10
0x00007f4a811848e4: mov    %r10d,%r11d
0x00007f4a811848e7: sub    %r9d,%r11d         ;*irem
                                              ; - org.sample.JavaBench::isEvenlyDivisible@9 (line 63)
                                              ; - org.sample.JavaBench::isEvenlyDivisible@19 (line 63)
                                              ; - org.sample.JavaBench::run@10 (line 54)