vmovdqa ymm0, YMMWORD PTR .LC0[rip]
  vmovdqa ymm3, YMMWORD PTR .LC1[rip]
  xor eax, eax
  vpxor xmm2, xmm2, xmm2
.L2:
  vpmulld ymm1, ymm0, ymm0
  inc eax
  vpaddd ymm0, ymm0, ymm3
  vpslld ymm1, ymm1, 1
  vpaddd ymm2, ymm2, ymm1
  cmp eax, 125000000      ; 8 calculations per iteration
  jne .L2
  vmovdqa xmm0, xmm2
  vextracti128 xmm2, ymm2, 1
  vpaddd xmm2, xmm0, xmm2
  vpsrldq xmm0, xmm2, 8
  vpaddd xmm0, xmm2, xmm0
  vpsrldq xmm1, xmm0, 4
  vpaddd xmm0, xmm0, xmm1
  vmovd eax, xmm0
  vzeroupper