# v: vector of size k
# k: max parts
#    (redundant: it's len(v))
# i: number of parts already in the vector
# n: elements left to partition
# s: minimum size of next part
#    (redundant: it's v[i - 1] unless i = 0, in which case it's 1)
# act(v, i): action to call with vector and number of parts
# Invariants: s <= n; i < k
def genpart_helper(v, k, i, n, s, act):
  # We can always use everything which is left
    v[i] = n; 
    act(v, i + 1)
  # If there is more than one part left, and we have
  # at least the twice the minimum number of elements left,
  # we can recurse
  if i + 1 < k:
    # This is python for: "for (int j = n/2; j >= s; --j)"
    for j in range(n // 2, s - 1, -1):
      v[i] = j
      genpart_helper(v, k, i + 1, n - j, j, act) 

# The top-level call. Checks the invariant, creates the vector,
# and calls the recursive function
def genparts(n, k, act):
  if k <= n and k >= 1:
    genpart_helper([0]*k, k, 0, n, 1, act)