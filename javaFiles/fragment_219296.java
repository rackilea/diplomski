import boto
import gzip
import psycopg2
import tempfile

# database connection setup
connection = psycopg2.connect('postgresql://scott:tiger@localhost/mydatabase')
connection.autocommit = True
cursor = connection.cursor()

# aws connection setup
s3_connection = boto.connect_s3('<aws access key>', '<aws secret key>')
bucket = s3_connection.get_bucket('<bucket>')

with tempfile.NamedTemporaryFile() as t:
    with gzip.GzipFile(t.name, mode='wb') as g:
        cursor.copy_expert("COPY ({0}) TO STDOUT WITH CSV HEADER".format('<select_query>'), g)
    key = boto.s3.key.Key(bucket, '<s3_key>')
    key.set_contents_from_filename(g.name)