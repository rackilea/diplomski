.file   "test.c"
    .def    ___main;    .scl    2;  .type   32; .endef
    .section .rdata,"dr"
LC0:
    .ascii "%d\12\0"
    .text
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
    andl    $-16, %esp
    subl    $32, %esp
    call    ___main
    movl    8(%ebp), %eax
    addl    %eax, %eax
    movl    %eax, 24(%esp)
    movl    $1, 28(%esp)
    jmp L2
L4:
    movl    28(%esp), %eax
    leal    1(%eax), %edx
    movl    %edx, 28(%esp)
    movl    %eax, 4(%esp)
    movl    $LC0, (%esp)
    call    _printf
L2:
    cmpl    $10, 28(%esp)
    jg  L3
    cmpl    $4, 24(%esp)
    jne L4
L3:
    movl    $0, %eax
    leave
    .cfi_restore 5
    .cfi_def_cfa 4, 4
    ret
    .cfi_endproc
LFE7:
    .ident  "GCC: (GNU) 4.8.2"
    .def    _printf;    .scl    2;  .type   32; .endef