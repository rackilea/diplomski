.file   "test.c"
    .def    ___main;    .scl    2;  .type   32; .endef
    .section .rdata,"dr"
LC0:
    .ascii "%d\12\0"
    .section    .text.startup,"x"
    .p2align 4,,15
    .globl  _main
    .def    _main;  .scl    2;  .type   32; .endef
_main:
LFB7:
    .cfi_startproc
    pushl   %ebp
    .cfi_def_cfa_offset 8
    .cfi_offset 5, -8
    movl    %esp, %ebp
    .cfi_def_cfa_register 5
    pushl   %ebx
    andl    $-16, %esp
    subl    $16, %esp
    .cfi_offset 3, -12
    call    ___main
    movl    8(%ebp), %eax
    leal    (%eax,%eax), %edx
    movl    $1, %eax
    cmpl    $4, %edx
    jne L8
    jmp L6
    .p2align 4,,7
L12:
    movl    %ebx, %eax
L8:
    leal    1(%eax), %ebx
    movl    %eax, 4(%esp)
    movl    $LC0, (%esp)
    call    _printf
    cmpl    $11, %ebx
    jne L12
L6:
    xorl    %eax, %eax
    movl    -4(%ebp), %ebx
    leave
    .cfi_restore 5
    .cfi_restore 3
    .cfi_def_cfa 4, 4
    ret
    .cfi_endproc
LFE7:
    .ident  "GCC: (GNU) 4.8.2"
    .def    _printf;    .scl    2;  .type   32; .endef