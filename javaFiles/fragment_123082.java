#!/usr/bin/perl

use strict;
use warnings;

use FindBin qw( $Bin );
use File::Spec::Functions qw( catfile );

use Win32::OLE;
use Win32::OLE::Const 'Microsoft PowerPoint';
$Win32::OLE::Warn = 3;

my $ppt = get_ppt();
$ppt->{Visible} = 1;

my $ppt_file = catfile $Bin, 'test.ppt';
my $doc = $ppt->Presentations->open( $ppt_file );
my $slides = $doc->Slides;
my $num_slides = $slides->Count;

for my $slide_idx (1 .. $num_slides) {
    print "=== Begin Slide $slide_idx ===\n";

    my $slide = $doc->Slides->Item( $slide_idx );
    my $shapes = $slide->Shapes;
    my $num_shapes = $shapes->Count;

    for my $shape_idx (1 .. $num_shapes) {
        my $shape = $shapes->Item($shape_idx);
        next unless $shape->HasTextFrame;

        my $pars = $shape->TextFrame->TextRange->Paragraphs;
        my $num_pars = $pars->Count;
        for my $par_idx (1 .. $num_pars) {
            my $par = $pars->Paragraphs($par_idx,1);
            print_par( $par );
        }
    }

    print "=== End Slide $slide_idx ===\n\n";
}

sub print_par {
    my ($par) = @_;
    my @bullets = qw( - * > + = @ );

    my $bullet_format = $par->ParagraphFormat->Bullet;
    my $bullet_type = $bullet_format->Type;

    my $bullet_char = '';

    if ($bullet_type == ppBulletNumbered) {
        $bullet_char = $bullet_format->Number . "\t";
    }
    elsif( $bullet_type == ppBulletUnnumbered ) {
        # Need a Unicode => ASCII mapping if you want to use
        # $bullet_format->Character
        my $indent = $par->IndentLevel % scalar @bullets;
        $bullet_char = $bullets[$indent] . "\t";
    }

    my $text = $par->Text;
    $text =~ s/\s+$//;

    print $bullet_char, $text,"\n";
}

sub get_ppt {
    my $app;
    eval {
        $app = Win32::OLE->GetActiveObject('PowerPoint.Application');
    };

    die "$@\n" if $@;

    unless($app) {
        $app = Win32::OLE->new(
            'PowerPoint.Application', sub { $_[0]->Quit }
        ) or die "Oops, cannot start PowerPoint: ",
                 Win32::OLE->LastError, "\n";
    }
    return $app;
}