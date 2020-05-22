mov    %ebp,0x10(%rax)    ;*putfield x00
...
mov    %rax,0x18(%r10)    ;*putfield o  <--- publish here
mov    %ebp,0x1c(%rax)    ;*putfield x03
mov    %ebp,0x18(%rax)    ;*putfield x02
mov    %ebp,0x14(%rax)    ;*putfield x01