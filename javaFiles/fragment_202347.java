6                later_init:
   7                .LFB0:
   8                    .file 1 "example.c"
   1:example.c     ****
   2:example.c     **** int later_init()
   3:example.c     **** {
   9                    .loc 1 3 0
  10                    .cfi_startproc
  11 0000 55            pushq   %rbp
  12                .LCFI0:
  13                    .cfi_def_cfa_offset 16
  14                    .cfi_offset 6, -16
  15 0001 4889E5        movq    %rsp, %rbp
  16                .LCFI1:
  17                    .cfi_def_cfa_register 6
   4:example.c     ****     int x;
   5:example.c     ****
   6:example.c     ****     x = 0;
  18                    .loc 1 6 0
  19 0004 C745FC00      movl    $0, -4(%rbp)
  19      000000
   7:example.c     ****
   8:example.c     ****     return x;
  20                    .loc 1 8 0
  21 000b 8B45FC        movl    -4(%rbp), %eax
   9:example.c     **** }
  22                    .loc 1 9 0
  23 000e 5D            popq    %rbp
  24                .LCFI2:
  25                    .cfi_def_cfa 7, 8
  26 000f C3            ret