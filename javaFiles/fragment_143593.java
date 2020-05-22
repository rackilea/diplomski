\G                        # Must start from where last match ends
(?:
  [^<>{}]++               # Outside {} <>
  |                       # OR
  <(?<pointy>[^<>]++)>    # Capture content inside < > in group named 'pointy'
  |                       # OR
  \{(?<curly>[^{}]++)\}   # Capture content inside < > in group named 'curly'
)