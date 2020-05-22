import os
import glob

path = 'c:\\rename'

files = [f for f in glob.glob(path + "**/*.pdf", recursive=True)]

for f in files:
    try:
        new = f.split('~')[0].replace(path,'').strip()
        os.rename(r'{}'.format(f), r'{}\{}.pdf'.format(path,new))
    except:
        print('cannot be renamed')