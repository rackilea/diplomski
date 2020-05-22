size_t CollectorPolicy::compute_heap_alignment() {
     // The card marking array and the offset arrays for old generations are
     // committed in os pages as well. Make sure they are entirely full (to
     // avoid partial page problems), e.g. if 512 bytes heap corresponds to 1
     // byte entry and the os page size is 4096, the maximum heap size should
     // be 512*4096 = 2MB aligned.

     size_t alignment = CardTableRS::ct_max_alignment_constraint();

     if (UseLargePages) {
         // In presence of large pages we have to make sure that our
         // alignment is large page aware.
         alignment = lcm(os::large_page_size(), alignment);
     }

     return alignment;
 }