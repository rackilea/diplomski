0.12%    0.04%    0x00007fb45518e7d1: mov    0x10(%r10),%rax    
 17.03%   23.44%    0x00007fb45518e7d5: test   %eax,0x17318825(%rip)
  0.21%    0.07%    0x00007fb45518e7db: mov    0x18(%r10),%r11    ; getfield offset
 30.33%   10.77%    0x00007fb45518e7df: mov    %rax,%r8
  0.00%             0x00007fb45518e7e2: add    $0x1,%r8           
  0.01%             0x00007fb45518e7e6: cmp    0xc(%r10),%r12d    ; typecheck 
                    0x00007fb45518e7ea: je     0x00007fb45518e80b ; bail to v-call
  0.83%    0.48%    0x00007fb45518e7ec: lock cmpxchg %r8,(%r10,%r11,1)
 33.27%   25.52%    0x00007fb45518e7f2: sete   %r8b
  0.12%    0.01%    0x00007fb45518e7f6: movzbl %r8b,%r8d          
  0.03%    0.04%    0x00007fb45518e7fa: test   %r8d,%r8d
                    0x00007fb45518e7fd: je     0x00007fb45518e7d1 ; back branch