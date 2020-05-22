# Generate a Doxygen configuration file, which
# should enable LaTeX output by default
doxygen -g

# Generate LaTeX documentation in the latex/ directory
doxygen

# Generate one Markdown file for each LaTeX file
find latex/ -name '*.tex' -exec mkdir -p markdown/`dirname {}` && \
    pandoc -o markdown/`basename {} .pdf`.md {} \;