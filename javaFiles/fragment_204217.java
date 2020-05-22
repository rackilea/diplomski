@relation period

@attribute minus_three {'CC', 'CD', 'DT', 'FW', 'IN', 'JJ', 'JJR', 'JJS', 'LS', 'MD', 'NN', 'NNPS', 'NNS', 'NP', 'PDT', 'PRP', 'PRP$', 'RB', 'RBR', 'RBS', 'RP', 'UH', 'VB', 'VBD', 'VBG', 'VBN', 'VBP', 'VBZ', 'WDT', 'WP','WRB', 'NUM', 'PUNC', 'NEND', 'RAND'}
@attribute minus_three_length real
@attribute minus_three_case {'UC','LC','NA'}
@attribute minus_two {'CC', 'CD', 'DT', 'FW', 'IN', 'JJ', 'JJR', 'JJS', 'LS', 'MD', 'NN', 'NNPS', 'NNS', 'NP', 'PDT', 'PRP', 'PRP$', 'RB', 'RBR', 'RBS', 'RP', 'UH', 'VB', 'VBD', 'VBG', 'VBN', 'VBP', 'VBZ', 'WDT', 'WP','WRB', 'NUM', 'PUNC', 'NEND', 'RAND'}
@attribute minus_two_length real
@attribute minus_two_case {'UC','LC','NA'}
@attribute minus_one {'CC', 'CD', 'DT', 'FW', 'IN', 'JJ', 'JJR', 'JJS', 'LS', 'MD', 'NN', 'NNPS', 'NNS', 'NP', 'PDT', 'PRP', 'PRP$', 'RB', 'RBR', 'RBS', 'RP', 'UH', 'VB', 'VBD', 'VBG', 'VBN', 'VBP', 'VBZ', 'WDT', 'WP','WRB', 'NUM', 'PUNC', 'NEND', 'RAND'}
@attribute minus_one_length real
@attribute minus_one_case {'UC','LC','NA'}
@attribute plus_one {'CC', 'CD', 'DT', 'FW', 'IN', 'JJ', 'JJR', 'JJS', 'LS', 'MD', 'NN', 'NNPS', 'NNS', 'NP', 'PDT', 'PRP', 'PRP$', 'RB', 'RBR', 'RBS', 'RP', 'UH', 'VB', 'VBD', 'VBG', 'VBN', 'VBP', 'VBZ', 'WDT', 'WP','WRB', 'NUM', 'PUNC', 'NEND', 'RAND'}
@attribute plus_one_length real
@attribute plus_one_case {'UC','LC','NA'}
@attribute plus_two {'CC', 'CD', 'DT', 'FW', 'IN', 'JJ', 'JJR', 'JJS', 'LS', 'MD', 'NN', 'NNPS', 'NNS', 'NP', 'PDT', 'PRP', 'PRP$', 'RB', 'RBR', 'RBS', 'RP', 'UH', 'VB', 'VBD', 'VBG', 'VBN', 'VBP', 'VBZ', 'WDT', 'WP','WRB', 'NUM', 'PUNC', 'NEND', 'RAND'}
@attribute plus_two_length real
@attribute plus_two_case {'UC','LC','NA'}
@attribute plus_three {'CC', 'CD', 'DT', 'FW', 'IN', 'JJ', 'JJR', 'JJS', 'LS', 'MD', 'NN', 'NNPS', 'NNS', 'NP', 'PDT', 'PRP', 'PRP$', 'RB', 'RBR', 'RBS', 'RP', 'UH', 'VB', 'VBD', 'VBG', 'VBN', 'VBP', 'VBZ', 'WDT', 'WP','WRB', 'NUM', 'PUNC', 'NEND', 'RAND'}
@attribute plus_three_length real
@attribute plus_three_case {'UC','LC','NA'}
@attribute left_before_reliable real
@attribute right_before_reliable real
@attribute spaces_follow_period real
@attribute class  {'EOS','NEOS'}

@data

VBP, 2, LC,NP, 4, UC,NN, 1, UC,NP, 6, UC,NEND, 1, NA,NN, 7, LC,31,47,1,NEOS
NNS, 10, LC,RBR, 4, LC,VBN, 5, LC,?, 3, NA,NP, 6, UC,NP, 6, UC,93,0,0,EOS
VBD, 4, LC,RB, 2, LC,RP, 4, LC,CC, 3, UC,UH, 5, LC,VBP, 2, LC,19,17,2,EOS