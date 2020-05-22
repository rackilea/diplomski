; 52   :             dInput[j] = myexp(dInput[j]);
; 53   :             dInput[j] = log10(dInput[j]);

    mov eax, esi
    shr eax, 16                 ; 00000010H
    and eax, 32767              ; 00007fffH
    imul    eax, eax, 1000
    movd    xmm0, eax
    cvtdq2pd xmm0, xmm0
    mulsd   xmm0, QWORD PTR __real@4137154700000000
    addsd   xmm0, QWORD PTR __real@41cff7893f800000
    call    __dtol3
    mov edx, eax
    xor ecx, ecx
    call    __ltod3
    call    __libm_sse2_log10_precise

; 54   :             dRes[i] += dInput[j];