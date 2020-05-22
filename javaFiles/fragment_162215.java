(?<=\.)                   # lookbehind to assert preceding char is DOT
(?=[^.]*$)                # lookahead to assert there is no further DOT in text
\p{Lu}                    # match a unicode uppercase letter
\p{L}*?                   # match 0 or more of unicode letters (non-greedy)
(?=\p{Lu}(?=[^\p{Lu}]*$)) # make sure next char is uppercase letter and further
                          # (?=[^\p{Lu}]*$) makes sure there is no uppercase letter after