import json
import argparse
import sys

# For command line arguments
parser = argparse.ArgumentParser(description='Converts JSON to respective SQL statement')
parser.add_argument('statement_type', type=str, nargs=1)
parser.add_argument('table_name', type=str, nargs=1)

# Reading the command line arguments
statement_type = parser.parse_args().statement_type[0]
table_name = parser.parse_args().table_name[0]

# Initialize SQL statement 
statement = ''

for line in sys.stdin:
  # Load JSON line
  json_line = json.loads(line)

  # Add table name and SQL syntax
  if statement_type == 'INSERT':
    statement += 'INSERT INTO {} '.format(table_name)

  # Add table parameters and SQL syntax
  statement += '({}) '.format(', '.join(json_line.keys()))

  # Add table values and SQL syntax
  # Note that strings are formatted with single quotes, other data types are converted to strings (for the join method)
  statement += "VALUES ({});".format(', '.join("'{0}'".format(value.replace("'", "''")) if type(value) == str else str(value) for value in json_line.values()))

  # Send statement to stdout
  print(statement)
​