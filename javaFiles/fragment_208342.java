mov    %edx,0x10(%rax)    ;*putfield x00                    
mov    %edx,0x14(%rax)    ;*putfield x01
mov    %edx,0x18(%rax)    ;*putfield x02
mov    %edx,0x1c(%rax)    ;*putfield x03
...
movb   $0x0,0x0(%r13,%rdx,1)  ;*putfield o